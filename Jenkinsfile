pipeline {
  agent any
  stages {
    stage('Upload Nexus') {
      steps {
        sh 'mvn clean deploy -f pom.xml'
      }
    }
  }
}