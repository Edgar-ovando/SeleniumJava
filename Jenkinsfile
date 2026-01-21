pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            agent {
                docker {
                     image 'maven:3.9.6-eclipse-temurin-17'
                     args '--shm-size=2g -u root:root'
                }
            }
            steps {
                sh '''
                    apt-get update
                    apt-get install -y chromium chromium-driver \
                        libnss3 libx11-xcb1 libxcomposite1 libxrandr2 libxdamage1 libxfixes3 \
                        libasound2 libatk1.0-0 libatk-bridge2.0-0 libgtk-3-0 fonts-liberation xdg-utils
                    export CHROME_BIN=/usr/bin/chromium
                    export CHROME_DRIVER=/usr/bin/chromedriver
                    mvn test
                '''

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
