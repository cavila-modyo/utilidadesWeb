pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      steps {
        sh 'docker pull maven:3-alpine'
        sh 'mvn clean deploy -f pom.xml'
      }
    }
  }
  environment {
    maven = '3.6.1'
  }
}