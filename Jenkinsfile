#!/usr/bin/env groovy

stage 'build'
  node {
    sshagent(['github-afrobot']) {
      sh """
        git fetch --all
        git checkout -b master
        git show-ref
        git tag
      """
    }
  }
