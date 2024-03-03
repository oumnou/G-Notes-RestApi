<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <title>Bootstrap demo</title>
  </head><body>
<section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
            class="img-fluid" alt="Phone image">
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <form id="signupForm">
            <!-- name input -->
            <div class="form-outline mb-4">
                <input type="text" placeholder="name" name="name" id="name" class="form-control form-control-lg" />
            </div>
        
            <!-- last name input -->
            <div class="form-outline mb-4">
                <input type="text" placeholder="last_name" name="last_name" id="last_name" class="form-control form-control-lg" />
            </div>
        
            <!-- username input -->
            <div class="form-outline mb-4">
                <input type="text" placeholder="username" name="username" id="username" class="form-control form-control-lg" />
            </div>
        
            <!-- Email input -->
            <div class="form-outline mb-4">
                <input type="email" id="email" name="email" placeholder="Email" class="form-control form-control-lg" />
            </div>
        
            <!-- Password input -->
            <div class="form-outline mb-4">
                <input type="password" placeholder="Password" name="password" id="password" class="form-control form-control-lg" />
            </div>
        
            <div id="errorContainer">
                <% if (request.getAttribute("emailExist") != null) { %>
                    <p style="color: red;">Email Exists</p>
                <%  } %>
            </div>
        
            <button type="button" onclick="signup()" class="btn btn-primary btn-lg btn-block">Sign up</button>
        </form>
        
        <script>
            function signup() {
                const form = document.getElementById('signupForm');
                const formData = new FormData(form);
                   // Convert form data to JSON object
                const jsonData = {};
                formData.forEach((value, key) => {
                    jsonData[key] = value;
                });
                fetch('http://localhost:9010/project/api/users/signup', {
                    method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData) // Convert JSON object to string
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to sign up');
        }
        return response.json();
    })
    .then(data => {
        // Handle successful signup
        console.log('User signed up successfully:', data);
        // Optionally, redirect to a new page or update UI
    })
    .catch(error => {
        // Handle errors
        console.error('Signup error:', error.message);
        // Display error message to the user or retry signup
    });
}
        </script>
        
        </div>
      </div>
    </div>
  </section>   
</body>
</html>
