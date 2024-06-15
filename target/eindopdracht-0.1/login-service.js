export default class LoginService {
    isLoggedIn() {
        return !!localStorage.getItem('accessToken');
    }

    login(user, password) {
        return fetch('http://localhost:8080/auth/login', { // Correct Tomcat URL
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username: user, password: password }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Login failed');
                }
                return response.json();
            })
            .then(data => {
                localStorage.setItem('accessToken', data.token);
            });
    }

    getUser() {
        return fetch('http://localhost:8080/auth/user', { // Correct Tomcat URL
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('accessToken')}`,
            },
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Invalid token or server error');
                }
                return response.json();
            })
            .catch(error => {
                console.error('Error checking user status:', error);
                return null;
            });
    }

    logout() {
        localStorage.removeItem('accessToken');
        return fetch('http://localhost:8080/auth/logout', { // Correct Tomcat URL
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('accessToken')}`,
            },
        })
            .then(() => {
                // Successful logout, no further action needed
            })
            .catch(error => {
                console.error('Logout failed:', error);
            });
    }
}
