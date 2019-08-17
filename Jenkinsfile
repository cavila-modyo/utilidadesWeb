pipeline {
  agent none
  stages {
    stage('Upload Nexus') {
      steps {
        sh 'mvn --settings /var/jenkins_home/plugins/settings.xml clean deploy -f pom.xml'
      }
    }
    stage('Borrar Workspace') {
      steps {
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanWhenNotBuilt: true, cleanWhenUnstable: true)
      }
    }
  }
}