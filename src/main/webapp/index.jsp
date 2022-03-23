<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html lang="${param.lang}">
    <head>
        <link rel="stylesheet" href="static/styles/login.css" />
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="static/scripts/login.js"></script>
    </head>
        <body>
            <div class="login-page">
                <main class="form">
                    <form class="login-form" method="post" action="login">
                        <h1 class="">Please sign in</h1>
                            <input name="login" type="text" class="form-control" id="floatingInput" placeholder="Login">
                            <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <button class="" type="submit">Sign in</button>
                        <p class="message">Not registered? <a href="#">Create an account</a></p>
                    </form>
                    <form class="register-form">
                        <h1 class="">Registration</h1>
                        <input type="text" placeholder="name"/>
                        <input type="password" placeholder="password"/>
                        <input type="text" placeholder="email address"/>
                        <button>create</button>
                        <p class="message">Already registered? <a href="#">Sign In</a></p>
                    </form>
                </main>
            </div>
        </body>
</html>



