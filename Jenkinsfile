pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          agent any
          steps {
            echo 'Inicia Build'
            sh 'mvn --settings /var/jenkins_home/plugins/settings.xml clean deploy -f pom.xml'
            echo 'Fin Build'
            slackSend(token: '8xVDBA48XlCFjCrG9lCyLmbj', teamDomain: 'enmilocalfuncionaco', channel: 'test', color: 'YELLOW', attachments: 'Se inicia Deploy Utilidades', baseUrl: 'https://enmilocalfuncionaco.slack.com', message: 'test', username: 'jenkins', botUser: true, tokenCredentialId: 'jenkins', iconEmoji: 'think')
          }
        }
        stage('Analisis SonarQube') {
          steps {
            sh '''mvn sonar:sonar \\
  -Dsonar.projectKey=utilidades-snapshot \\
  -Dsonar.host.url=http://190.160.136.181:9011 \\
  -Dsonar.login=ed08305680dc45b067e9b2af2d7cc650471fe415'''
          }
        }
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