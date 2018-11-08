/**
 * @author zangyanming
 * checkDateTime函数检测会议申请中的开始时间与结束时间范围内，会议室是否被占用
 */
package com.kalix.oa.workflow.meetingapply.biz;


import com.kalix.admin.core.api.biz.IUserBeanService;
import com.kalix.admin.core.entities.UserBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.core.util.BeanUtil;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.system.meetingroom.api.biz.IMeetingroomBeanService;
import com.kalix.oa.workflow.meetingapply.api.biz.IMeetingApplyBeanService;
import com.kalix.oa.workflow.meetingapply.api.dao.IMeetingApplyBeanDao;
import com.kalix.oa.workflow.meetingapply.entities.MeetingApplyBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MeetingApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IMeetingApplyBeanDao, MeetingApplyBean> implements IMeetingApplyBeanService {
    private IMeetingroomBeanService meetingroomBeanService;

    private IUserBeanService userBeanService;

    public IMeetingroomBeanService getMeetingroomBeanService() {
        return meetingroomBeanService;
    }

    public void setMeetingroomBeanService(IMeetingroomBeanService meetingroomBeanService) {
        this.meetingroomBeanService = meetingroomBeanService;
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, MeetingApplyBean bean) {
        if (bean.getApproveDeadline() == null) {
            //如果前台没有设置重要参与人的审批超时时间，默认是30分钟
            map.put("duTime", "PT1M");
        } else {
//            map.put("duTime", bean.getApproveDeadline().getTime() - (new Date()).getTime());
            map.put("duTime", "PT" + (bean.getApproveDeadline().getTime() - (new Date()).getTime()) / 1000 / 60 + "M");
        }

        return map;
    }

    @Override
    public MeetingApplyBean getEntity(String id) {
        MeetingApplyBean meetingApplyBean = super.getEntity(id);
        String meetingSummaryPersonName = "", importantAttendeesName = "", otherAttendeesName = "";
        List<MeetingApplyBean> bean = new ArrayList<>();
        bean.add(meetingApplyBean);
        List ids = BeanUtil.getBeanFieldValueList(bean, "meetingroomId");
        List values = this.meetingroomBeanService.getFieldValuesByIds(ids.toArray(), "name");
        meetingApplyBean.setMeetingroomName((String) values.get(0));

        if (meetingApplyBean.getMeetingSummaryPerson() != null && !meetingApplyBean.getMeetingSummaryPerson().isEmpty()) {
            for (int i = 0; i < meetingApplyBean.getMeetingSummaryPerson().split(",").length; i++) {
                if (!meetingApplyBean.getMeetingSummaryPerson().split(",")[i].equals("")) {
                    UserBean userBean = userBeanService.getEntity(meetingApplyBean.getMeetingSummaryPerson().split(",")[i]);
                    if (userBean != null) {
                        meetingSummaryPersonName += userBean.getName() + ",";
                    }
                }
            }
            if (meetingSummaryPersonName.length() > 1) {
                meetingSummaryPersonName = meetingSummaryPersonName.substring(0, meetingSummaryPersonName.length() - 1);
            }
            meetingApplyBean.setMeetingSummaryPersonName(meetingSummaryPersonName);
        }


        if (!meetingApplyBean.getImportantAttendees().isEmpty()) {
            for (int k = 0; k < meetingApplyBean.getImportantAttendees().split(",").length; k++) {
                if (!meetingApplyBean.getImportantAttendees().split(",")[k].equals("")) {
                    UserBean userBean = userBeanService.getEntity(meetingApplyBean.getImportantAttendees().split(",")[k]);
                    importantAttendeesName += userBean.getName() + ",";
                }
            }
            if (importantAttendeesName.length() > 1) {
                importantAttendeesName = importantAttendeesName.substring(0, importantAttendeesName.length() - 1);
            }
            meetingApplyBean.setImportantAttendeesName(importantAttendeesName);
        }

        if (meetingApplyBean.getMeetingSummaryPerson() != null && !meetingApplyBean.getMeetingSummaryPerson().isEmpty()) {
            for (int l = 0; l < meetingApplyBean.getMeetingSummaryPerson().split(",").length; l++) {
                if (!meetingApplyBean.getOtherAttendees().split(",")[l].equals("")) {
                    UserBean userBean = userBeanService.getEntity(meetingApplyBean.getOtherAttendees().split(",")[l]);
                    otherAttendeesName += userBean.getName() + ",";
                }
            }
            if (otherAttendeesName.length() > 1) {
                otherAttendeesName = otherAttendeesName.substring(0, otherAttendeesName.length() - 1);
            }
            meetingApplyBean.setOtherAttendeesName(otherAttendeesName);
        }

        return meetingApplyBean;
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr) {
        JsonData jsonData = new JsonData();
        jsonData = super.getAllEntityByQuery(page, limit, jsonStr);

        /**
         * 以下代码，是为了前台显示用的，将会议室id翻译为会议室名称
         */
        List beans = jsonData.getData();
        List ids = BeanUtil.getBeanFieldValueList(beans, "meetingroomId");
        List values = this.meetingroomBeanService.getFieldValuesByIds(ids.toArray(), "name");
        BeanUtil.setBeanListFieldValues(beans, "meetingroomName", values);

        for (int i = 0; i < beans.size(); i++) {
            String meetingSummaryPersonName = "", importantAttendeesName = "", otherAttendeesName = "";
            MeetingApplyBean meetingApplyBean = (MeetingApplyBean) beans.get(i);
            String[] meetingSummaryPerson = meetingApplyBean.getMeetingSummaryPerson().split(",");
            if (meetingApplyBean.getMeetingSummaryPerson() != null && !meetingApplyBean.getMeetingSummaryPerson().isEmpty()) {
                for (int j = 0; j < meetingSummaryPerson.length; j++) {
                    if (!meetingSummaryPerson[j].equals("")) {
                        UserBean userBean = userBeanService.getEntity(meetingSummaryPerson[j]);
                        if (userBean != null) {
                            meetingSummaryPersonName += userBean.getName() + ",";
                        }
                    }
                }
                if (meetingSummaryPersonName.length() > 1) {
                    meetingSummaryPersonName = meetingSummaryPersonName.substring(0, meetingSummaryPersonName.length() - 1);
                }
                ((MeetingApplyBean) beans.get(i)).setMeetingSummaryPersonName(meetingSummaryPersonName);
            }


            if (!meetingApplyBean.getImportantAttendees().isEmpty()) {
                String[] meetingAttendeesSplit = meetingApplyBean.getImportantAttendees().split(",");
                for (int k = 0; k < meetingAttendeesSplit.length; k++) {
                    if (!meetingAttendeesSplit[k].equals("")) {
                        UserBean userBean = userBeanService.getEntity(meetingAttendeesSplit[k]);
                        importantAttendeesName += userBean.getName() + ",";
                    }
                }
                if (importantAttendeesName.length() > 1) {
                    importantAttendeesName = importantAttendeesName.substring(0, importantAttendeesName.length() - 1);
                }
                ((MeetingApplyBean) beans.get(i)).setImportantAttendeesName(importantAttendeesName);
            }

            if (meetingApplyBean.getMeetingSummaryPerson() != null && !meetingApplyBean.getMeetingSummaryPerson().isEmpty()) {
                for (int l = 0; l < meetingSummaryPerson.length; l++) {
                    String[] otherAttendeesSplit = meetingApplyBean.getOtherAttendees().split(",");
                    if (!otherAttendeesSplit[l].equals("")) {
                        UserBean userBean = userBeanService.getEntity(otherAttendeesSplit[l]);
                        otherAttendeesName += userBean.getName() + ",";
                    }
                }
                if (otherAttendeesName.length() > 1) {
                    otherAttendeesName = otherAttendeesName.substring(0, otherAttendeesName.length() - 1);
                }
                ((MeetingApplyBean) beans.get(i)).setOtherAttendeesName(otherAttendeesName);
            }
        }

        jsonData.setTotalCount((long) beans.size());
        jsonData.setData(beans);

        return jsonData;
    }

    /**
     * 用于检测在会议申请的时间范围内，是否该与该会议室已经申请的会议试讲有冲突
     *
     * @param jsonStr
     * @return
     */
    @Override
    public JsonStatus checkDateTime(String jsonStr) {
        MeetingApplyBean entity = SerializeUtil.unserializeJson(jsonStr, MeetingApplyBean.class);
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setMsg("0");
        String id;
        if (entity.getId() == null) {
            id = "-1";
        } else {
            id = entity.getId();
        }

        String meetingroomId = entity.getMeetingroomId();
        //Date meetingDate = entity.getMeetingDate();

        Date beginDateTime = new Date();
        Date beginTime = entity.getBeginTime();
//        beginDateTime.setYear(entity.getMeetingDate().getYear());
//        beginDateTime.setMonth(entity.getMeetingDate().getMonth());
//        beginDateTime.setDate(entity.getMeetingDate().getDate());
        beginDateTime.setHours(beginTime.getHours());
        beginDateTime.setMinutes(beginTime.getMinutes());
        beginDateTime.setSeconds(beginTime.getSeconds());

        Date endDateTime = new Date();//entity.getMeetingDate();
        Date endTime = entity.getEndTime();
//        endDateTime.setYear(entity.getMeetingDate().getYear());
//        endDateTime.setMonth(entity.getMeetingDate().getMonth());
//        endDateTime.setDate(entity.getMeetingDate().getDate());
        endDateTime.setHours(endTime.getHours());
        endDateTime.setMinutes(endTime.getMinutes());
        endDateTime.setSeconds(endTime.getSeconds());

        try {
            Date row_beginTime, row_endTime, row_beginDateTime, row_endDateTime;
            List<MeetingApplyBean> list = dao.find("select ob from MeetingApplyBean ob where ob.id <> ?1 and ob.meetingroomId=?2", id, meetingroomId);
            for (int i = 0; i < list.size(); i++) {
                row_beginTime = list.get(i).getBeginTime();
                row_endTime = list.get(i).getEndTime();

                row_beginDateTime = new Date();
//                row_beginDateTime.setYear(list.get(i).getMeetingDate().getYear());
//                row_beginDateTime.setMonth(list.get(i).getMeetingDate().getMonth());
//                row_beginDateTime.setDate(list.get(i).getMeetingDate().getDate());
                row_beginDateTime.setHours(row_beginTime.getHours());
                row_beginDateTime.setMinutes(row_beginTime.getMinutes());
                row_beginDateTime.setSeconds(row_beginTime.getSeconds());

                row_endDateTime = new Date();
//                row_endDateTime.setYear(list.get(i).getMeetingDate().getYear());
//                row_endDateTime.setMonth(list.get(i).getMeetingDate().getMonth());
//                row_endDateTime.setDate(list.get(i).getMeetingDate().getDate());
                row_endDateTime.setHours(row_endTime.getHours());
                row_endDateTime.setMinutes(row_endTime.getMinutes());
                row_endDateTime.setSeconds(row_endTime.getSeconds());

                if (beginDateTime.before(row_beginDateTime) && endDateTime.after(row_beginDateTime)) {
                    jsonStatus.setMsg("1");
                    break;
                }
                if (Math.abs(beginDateTime.getTime() - row_beginDateTime.getTime()) < 1000) {
                    jsonStatus.setMsg("1");
                    break;
                }
                if (beginDateTime.after(row_beginDateTime) && beginDateTime.before(row_endDateTime)) {
                    jsonStatus.setMsg("1");
                    break;
                }
            }

            jsonStatus.setSuccess(true);
        } catch (Exception e) {
            jsonStatus.setMsg("1");
            jsonStatus.setSuccess(false);
        }
        return jsonStatus;
    }

    /**
     * 查询给定日期当天会议室的使用情况
     *
     * @param date
     * @return
     */
    @Override
    public JsonData reservation(Date date) {
        if (date == null) return null;
        JsonData jsonData = new JsonData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        List<PersistentEntity> beans = dao.findByNativeSql("select ob from MeetingApplyBean ob where ob.meetingDate >=1? and ob.meetingDate <=2?", MeetingApplyBean.class, dateStr + "00:00:00", dateStr + "23:59:59");

        jsonData.setData(beans);
        jsonData.setTotalCount((long) beans.size());
        return jsonData;
    }

    /**
     * 查询特定会议室在给定日期当天会议室的使用情况
     *
     * @param roomId
     * @param date
     * @return
     */
    @Override
    public JsonData reservation(String roomId, Date date) {
        if (date == null) return null;
        JsonData jsonData = new JsonData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        List<PersistentEntity> beans = dao.findByNativeSql("select ob from MeetingApplyBean ob where ob.meetingRoomId = ?1 ob.meetingDate >= 2? and ob.meetingDate <= 3?", MeetingApplyBean.class, roomId, dateStr + "00:00:00", dateStr + "23:59:59");

        jsonData.setData(beans);
        jsonData.setTotalCount((long) beans.size());
        return jsonData;
    }

    @Override
    public void getStartMap(Map map, MeetingApplyBean bean) {
        //List<String> assigneeList = Arrays.asList("郑立国", "王静", "纪雪莲");
        List<String> assigneeList = new ArrayList<>();
        String importantAttendees = bean.getImportantAttendees();
        if (importantAttendees.length() > 0) {
            String[] split = importantAttendees.split(",");
            for (int i = 0; i < split.length; i++) {
                //根据用户id转成loginName
                String userId = split[i];
                UserBean userBean = userBeanService.getEntity(userId);
                assigneeList.add(userBean.getLoginName());
            }
        }
        map.put("assigneeList", assigneeList);
        map.put("isAttend", false);
        super.getStartMap(map, bean);
    }
}
