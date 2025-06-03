function validatePasswords() {
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    if(password.value !== confirmPassword.value) {
        confirmPassword.classList.add('is-invalid');
        return false;
    }
    else{
        confirmPassword.classList.remove('is-invalid');
        return true;
    }
}