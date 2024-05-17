pipeline {
    agent any

    environment {
        SONARSERVER = 'sonarserver'
        SONARSCANNER = 'sonarscanner5' // updated to match tool name used in the environment
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/build/libs/*.war'
                }
            }
        }

        stage('Unit Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Integration Test') {
            steps {
                sh './gradlew integrationTest'
            }
        }

        stage('Code Analysis with Checkstyle') {
            steps {
                sh './gradlew checkstyleMain'
            }
            post {
                success {
                    echo 'Generated Analysis Result'
                }
            }
        }

        stage('Code Analysis with SonarQube') {
            environment {
                scannerHome = tool name: 'sonarscanner5', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
            }

            steps {
                withSonarQubeEnv('sonar-pro') {
                    sh '''${scannerHome}/bin/sonar-scanner \
                        -Dsonar.projectKey=zohraBarkouch_Project_1_4c992da5-621a-4f74-ab00-ab7420e91747 \
                        -Dsonar.projectName=Project_1 \
                        -Dsonar.projectVersion=1.0 \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.tests=src/test/java \
                        -Dsonar.java.binaries=build/classes/java/main \
                        -Dsonar.junit.reportsPath=build/test-results/test \
                        -Dsonar.jacoco.reportPaths=build/jacoco/test.exec \
                        -Dsonar.java.checkstyle.reportPaths=build/reports/checkstyle/main.xml'''
                }
            }
        }
    }
}
