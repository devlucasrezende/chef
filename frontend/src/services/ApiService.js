import api from '../api';

class ApiService {
  getAll() {
    return api.get('/receitas');
  }

  get(id) {
    return api.get(`/receitas/${id}`);
  }

  create(data) {
    return api.post('/receitas', data);
  }

  update(id, data) {
    return api.put(`/receitas/${id}`, data);
  }

  delete(id) {
    return api.delete(`/receitas/${id}`);
  }
}

export default new ApiService();
