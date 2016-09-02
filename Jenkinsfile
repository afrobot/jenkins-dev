#!/usr/bin/env groovy

/**
 * Jenkins job must be parametrized
 *
 * devRepo       - url to development version of repo
 * prodRepo      - url to production version of repo
 * credentialsId - credentials
 */

node {
  try {

    stage('setup') {
      checkout scm
      sh 'git show-ref --head'
      step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
    }


    stage('build') {
      echo "build"
    }


    stage('test') {
      echo "test"
    }


    stage('sync-master') {
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

    error()
    currentBuild.result = 'SUCCESS'
    echo currentBuild.dump()

  } catch(e) {
    currentBuild.result = 'FAILURE'
    throw(e)

  } finally {
    step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
  }
}
