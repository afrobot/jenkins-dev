#!/usr/bin/env groovy

stage 'build'
  node {
    checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-afrobot', url: 'git@github.com:afrobot/jenkins-dev.git']]])
    sh """
      git fetch --all
      git checkout -b master
      git show-ref
      git tag
    """
  }
