pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
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