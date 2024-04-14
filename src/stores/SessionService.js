// SessionService.js

const SessionService = {
    // Lưu giá trị vào sessionStorage
    setItem(key, value) {
      sessionStorage.setItem(key, JSON.stringify(value));
    },
    
    // Lấy giá trị từ sessionStorage
    getItem(key) {
      const value = sessionStorage.getItem(key);
      return value ? JSON.parse(value) : null;
    },
    
    // Xóa giá trị từ sessionStorage
    removeItem(key) {
      sessionStorage.removeItem(key);
    },
    
    // Xóa toàn bộ sessionStorage
    clear() {
      sessionStorage.clear();
    }
  };
  
  export default SessionService;
  