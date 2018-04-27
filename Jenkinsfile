// refer to https://github.com/siamaksade/cart-service/blob/jenkinsfiles/Jenkinsfile
node('maven') {
  stage('Build OA App') {
    git url: "https://github.com/chenyanxu/oa-parent.git"
    sh "mvn install -DskipTests=true -s settings.xml"
  }
  stage('Deploy OA App') {
    sh "mvn deploy -DskipTests=true -s settings.xml"
  }
}
