#!/usr/bin/env groovy

devRepo = 'git@github.com:afrobot/jenkins-dev.git'
prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

node {
  stage("init") {
    checkout scm
    utils = load 'utils.groovy'
    utils.extendEnv()

    echo env.FOO
    // env.GIT_SHA1 = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
  }

  stage("build") {
    utils.extendEnv()
  }

  stage("tests") {

  }

  catchError() {

  }
}


// node {
//   stage 'checkout'
//     checkoutRepo(devRepo, prodRepo)
//     checkout scm
//
//   stage 'build'
//     sshagent(['github-afrobot']) {
//       sh """
//         git fetch --all
//         git show-ref
//         git ls-remote
//       """ }
//
// }



// stage 'build'
//   node {
//     //checkout scm
//     sshagent(['github-afrobot']) {
//       git url: 'git@github.com:afrobot/jenkins-dev.git', credentialsId: 'github-afrobot', name: 'origin'
//
//       addRemoteRepo(prodRepo)
//
//       sh """
//         git fetch --all
//         git show-ref
//         git branch
//         git diff origin/master
//         git ls-remote
//       """
//     }
//   }
//   }
//

// def checkoutRepo(devRepo, prodRepo) {
//   checkout([
//     $class:'GitSCM',
//     branches: [[name: 'master']],
//     extensions: [[$class: 'WipeWorkspace']],
//     userRemoteConfigs: [
//       [credentialsId: 'github-afrobot', url: "${devRepo}",  name: 'origin'],
//       [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
//     ]])
// }
//
// class Utils {
//
// }



// usuwanie niepotrzebnych developerskich tagow:
// git tag | grep -v "^[0-9.]*$" | xargs git tag -d

// git fetch --all
// git show-ref
// git branch
// git diff origin/master
// git ls-remote
