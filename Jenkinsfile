pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        echo 'Inicia Build'
        sh 'mvn --settings /var/jenkins_home/plugins/settings.xml clean deploy -f pom.xml'
        echo 'Fin Build'
      }
    }
    stage('Borrar Workspace') {
      steps {
        echo 'Inicio'
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenNotBuilt: true, cleanWhenSuccess: true, cleanWhenUnstable: true, cleanupMatrixParent: true)
        echo 'Fin'
      }
    }
  }
  tools {
    maven 'maven'
  }
}