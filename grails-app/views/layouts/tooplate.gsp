<%--
  Created by IntelliJ IDEA.
  User: LT530
  Date: 1/5/2015
  Time: 9:52 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Blue</title>


    <asset:stylesheet src="tooplate_style.css"/>


    <asset:javascript src="application.js"/>
    <g:layoutHead/>

</head>

<body>

<span id="top"></span>
<div id="tooplate_body_wrapper">
    <div id="tooplate_wrapper">
        <div id="tooplate_header">
            <div id="site_title">
                <h1><a href="#">Blue Spark</a></h1>
            </div>
            <div id="tooplate_menu">
                <ul>

                    <li><a href="/upporc/start">Home</a></li>

                    <li><a href="#aboutus">About Us</a></li>
                    <li><a href="#blog">Blank</a></li>
                    <li><a href="#portfolio">Portfolio</a></li>
                    <li class="last"><a href="#contactus">Contact</a></li>


                </ul>
            </div> <!-- end of tooplate_menu -->
        </div> <!-- end of header -->

        <div id="tooplate_main">

            <div id="home" class="content_top"></div>
            <div class="content_box">
                <div class="content_title content_ct"><h2>Welcome</h2></div>
                <div class="content">
                    <div class="image_wrapper image_fl"> <asset:image src="ecg1.jpg" alt="ECG" height="100" /><span></span></div>
                    <p><em>to be filled #1.</em></p>



                    <div class="cleaner h30"></div>

                    <g:layoutBody/>

                    <div class="cleaner"></div>

                    <div class="col_w340 float_l">
                        <h3>Lists</h3>
                        <ul >
                            <li>Nulla facilisi. Maecenas ac odio ipsum donec cursus</li>

                        </ul>
                    </div>


                    <div class="col_w340 float_r">
                        <h3>Content</h3>
                        <blockquote>
                            <p>This part to be filled in. </p>




                    </div>

                    <div class="cleaner"></div>
                </div>

            </div>


        </div>




    </div>


</div>



<div id="tooplate_footer">
    Copyright © 2015 <a href="#">Company Name</a>
</div>


</body>
</html>