pipeline {
    agent any

    environment {
        SELENIUM_HUB_URL = 'http://selenium:4444/wd/hub'
    }

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.6-openjdk-11'
                    args '-u root:root'
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9.6-openjdk-11'
                    args '-u root:root'
                }
            }
            steps {
                sh '''
                    set -e
                    # Instalar Chrome y dependencias necesarias
                    apt-get update
                    apt-get install -y wget unzip gnupg2 curl
                    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -
                    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
                    apt-get update && apt-get install -y google-chrome-stable

                    # Instalar ChromeDriver
                    CHROME_VERSION=$(google-chrome --version | grep -oP '\d+\.\d+\.\d+')
                    wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/${CHROME_VERSION}/chromedriver_linux64.zip
                    unzip /tmp/chromedriver.zip -d /usr/local/bin/
                    chmod +x /usr/local/bin/chromedriver

                    # Ejecutar tests
                    mvn test"
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
