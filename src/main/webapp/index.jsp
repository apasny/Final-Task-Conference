<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html>
    <head>
        <link rel="stylesheet" href="static/styles/bootstrap.min.css" />
        <link rel="stylesheet" href="static/styles/signin.css" />
    </head>
        <body class="text-center">
            <main class="form-signin">
              <form method="post" action="controller?command=login">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                <div class="form-floating">
                  <input name="login" type="text" class="form-control" id="floatingInput" placeholder="Login">
                  <label for="floatingInput">Login</label>
                </div>
                <div class="form-floating">
                  <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                  <label for="floatingPassword">Password</label>
                </div>
                <div class="checkbox mb-3">
                  <label>
                    <input type="checkbox" value="remember-me"> Remember me
                  </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
              </form>
            </main>

        </body>
</html>



