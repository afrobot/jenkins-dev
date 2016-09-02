#!/usr/bin/env groovy

/**
 * Jenkins job must be parametrized
 *
 * devRepo       - url to development version of repo
 * prodRepo      - url to production version of repo
 * credentialsId - credentials
 */

// devRepo = 'git@github.com:afrobot/jenkins-dev.git'
// prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

run {
  stage("build") {
  }

  stage("tests") {
  }
}

def run(code) {
  node {
    try {
      stage("init") {
        checkout scm
        step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
      }

      code()

      stage("sync-master") {
        // git remote add prod ...
        checkout([
          $class:'GitSCM',
          extensions: [[$class: 'WipeWorkspace']],
          userRemoteConfigs: [
            [credentialsId: credentialsId, url: prodRepo, name: 'prod'],
            [credentialsId: credentialsId, url: devRepo,  name: 'origin']
          ]])
        // checkout again to correct sha1
        checkout scm

        sshagent([credentialsId]) {
          sh '''
            git fetch --all
            git checkout master

            # remove non-production tags
            git tag | grep -v "^[0-9.]*$" | xargs git tag -d

            # do the synchronization between origin/master and prod/master
            git push prod master --tags
          '''
        }
      }

      env.result = 'SUCCESS'

    } catch(e) {
      env.result = 'FAILURE'
      throw(e)

    } finally {
      step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
    }
  }
}
