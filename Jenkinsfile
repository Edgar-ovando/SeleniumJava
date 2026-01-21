pipeline {
    agent any

    environment {
        SELENIUM_HUB_URL = 'http://selenium:4444/wd/hub'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '-u root:root'
                    }
                  }
            steps {
                sh '''
                    apt-get update && apt-get install -y maven
                    mvn test
                '''

                //sh "mvn test -Dselenium.hub.url=$SELENIUM_HUB_URL"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Simulando un despliegue a un servidor de aplicaciones'
            }
        }
    }

    post {
        always {
            echo 'Siempre se ejecutará'
        }
        success {
            echo 'Pipeline ejecutado exitosamente ✅'
        }
        failure {
            echo 'El pipeline falló ❌'
        }
    }
}
