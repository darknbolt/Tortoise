function validatePasswords() {
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    console.log("validate called");

    if(password.value !== confirmPassword.value) {
        confirmPassword.classList.add('is-invalid');
        return false;
    }
    else{
        confirmPassword.classList.remove('is-invalid');
        return true;
    }
}