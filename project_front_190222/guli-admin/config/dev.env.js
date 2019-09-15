'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  //  BASE_API: '"https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin"'
  BASE_API: '"http://127.0.0.1:8210"',
  OSS_PATH: '"https://guli-file-0222.oss-cn-shanghai.aliyuncs.com"'

})
