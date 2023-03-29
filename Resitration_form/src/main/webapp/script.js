
function submitForm(event) {
    event.preventDefault();
    const form = document.getElementById("formin");
    const formData = new FormData(form);
    const data = {};
    for (let [key, value] of formData.entries()) {
      data[key] = value;
    }
    console.log(data);
    if(checkInputs(data))
    {
        form.submit();
    }
  }
  function checkInputs(data) {
    let name = data.name;
    let email = data.email;
    let gender = data.gender;
    let dob = data.dateofbirth;
    let role = data.role;
    let phonenumber = data.phonenumber;
    let errors = [];
    if (name.trim() === "") {
      errors.push("Name is required");
    }
  
    if (email.trim() === "") {
      errors.push("Email is required");
    } else if (!isValidEmail(email)) {
      errors.push("Email is not valid");
    }
  
    if (gender === undefined || gender === null || gender.trim() === "") {
      errors.push("Gender is required");
    }
  
    if (dob === undefined || dob === null || dob.trim() === "") {
      errors.push("Date of birth is required");
    } else if (!isValidDate(dob)) {
      errors.push("Date of birth is not valid");
    }
  
    if (role === undefined || role === null || role.trim() === "") {
      errors.push("Role is required");
    }
  
    if (phonenumber.trim() === "") {
      errors.push("Phone number is required");
    } else if (!isValidPhoneNumber(phonenumber)) {
      errors.push("Phone number is not valid");
    }
  
    if (errors.length > 0) {
      console.log(errors);
      return false;
    }
    console.log(name, email, gender, dob, role, phonenumber);
    return true;
  }
  
  function isValidEmail(email) {
    const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    return regex.test(email);
  }
  
  function isValidDate(dob) {
    return moment(dob, "YYYY-MM-DD", true).isValid();
  }
  
  function isValidPhoneNumber(phonenumber) {
    const regex = /^\d{10}$/;
    return regex.test(phonenumber);
  }
