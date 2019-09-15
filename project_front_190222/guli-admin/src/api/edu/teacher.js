import request from '@/utils/request'

const api_name = '/admin/edu/teacher'
export default {
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },

  removeById(id) {
    return request({
      url: `${api_name}/${id}`,
      method: 'delete'
    })
  },

  save(teacher) {
    return request({
      url: api_name,
      method: 'post',
      data: teacher
    })
  },

  updateById(teacher) {
    return request({
      url: `${api_name}/${teacher.id}`,
      method: 'put',
      data: teacher
    })
  },

  getById(id) {
    return request({
      url: `${api_name}/${id}`,
      method: 'get'
    })
  },

  getList() {
    return request({
      url: api_name,
      method: 'get'
    })
  }
}
