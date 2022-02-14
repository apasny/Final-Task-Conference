<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html>
    <head>
        <link rel="stylesheet" href="static/styles/signin.css" />
    </head>
        <body class="">
            <main class="form-signin">
              <form method="post" action="controller?command=login">
                <h1 class="">Please sign in</h1>
                <div class="">
                  <input name="login" type="text" class="form-control" id="floatingInput" placeholder="Login">
                  <label for="floatingInput">Login</label>
                </div>
                <div class="">
                  <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                  <label for="floatingPassword">Password</label>
                </div>
                <button class="" type="submit">Sign in</button>
              </form>
            </main>

        </body>
</html>



