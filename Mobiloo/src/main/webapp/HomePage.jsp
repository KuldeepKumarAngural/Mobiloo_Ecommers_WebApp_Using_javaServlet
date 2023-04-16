<%@page import="com.mobiloo_UploadSection.UploadDto"%>
<%@page import="com.mobiloo_UploadSection.UploadControll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
  </head>
  <style>

*{
    padding: 0;
    margin: 0;
    text-decoration: none;
    list-style: none;
    box-sizing: border-box;
  }
  a.noclick       {
  pointer-events: none;
}
  body{
    font-family: montserrat;
    background-image:  linear-gradient(#0082e6,rgb(79, 155, 225),rgb(75, 128, 242) );
  }
  nav{
    background: #0082e6;
    height: 80px;
    width: 100%;
   
  }
  label.logo{
    color: white;
    font-size: 35px;
    line-height: 80px;
    padding: 0 100px;
    font-weight: bold;
  }
  nav ul{
    float: right;
    margin-right: 20px;
  }
  nav ul li{
    display: inline-block;
    line-height: 80px;
    margin: 0 5px;
  }
  nav ul li a{
    color: white;
    font-size: 17px;
    padding: 7px 13px;
    border-radius: 3px;
    text-transform: uppercase;
  }
  nav ul li a:hover{
    color: #2c3e50;
  }
  a.active,a:hover{
    background: #1b9bff;
    transition: .5s;
  }
  .checkbtn{
    font-size: 30px;
    color: white;
    float: right;
    line-height: 80px;
    margin-right: 40px;
    cursor: pointer;
    display: none;
  }
  #check{
    display: none;
  }
  @media (max-width: 952px){
    label.logo{
      font-size: 30px;
      padding-left: 50px;
    }
    nav ul li a{
      font-size: 16px;
    }
  }
  @media (max-width: 858px){
    .checkbtn{
      display: block;
    }
    ul{
      position: fixed;
      width: 100%;
      height: 100vh;
      background: #2c3e50;
      top: 80px;
      left: -100%;
      text-align: center;
      transition: all .5s;
    }
    nav ul li{
      display: block;
      margin: 50px 0;
      line-height: 30px;
    }
    nav ul li a{
      font-size: 20px;
    }
    a:hover,a.active{
      background: none;
      color: #0082e6;
    }
    #check:checked ~ ul{
      left: 0;
    }
  }
  section{
    background: url(bg1.jpg) no-repeat;
    background-size: cover;
    height: calc(100vh - 80px);
  }
#main{
  background-color: #0082e6;
  position: relative;
  text-align: center;
}

.container {
  max-width: 1200px;
  margin: auto;
  
  top: 10px;
  padding-bottom: 80px;
}
.grid-row {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 350px));
  grid-gap: 15px 15px;
  justify-content: center;
  align-items: baseline;
 
 
}


.grid-row .grid-item span {
  padding: 10px;
  line-height: 1;
  border: 2px solid black;
}
.grid-row .grid-item h3 {
  font-size: 20px;
  margin-bottom: 0;
}
.grid-row .grid-item:hover {
  filter: contrast(0.5);
  zoom: 1.1;
}
.grid-row .grid-item {
  transition: filter 0.5s ease;
  display: flex;
  cursor: pointer;
  background: var(--light);
  box-shadow: var(--shadow);
  color: var(--dark);
  text-align: center;
  font-family: sans-serif;
  flex-direction: column-reverse;
  align-items: stretch;
}



  


  
  </style>
  <body>
    <nav>
      <input type="checkbox" id="check"> 
      <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
      </label>
      <label class="logo">Mobiloo</label>
      <ul>
        <li><a class="active" href="index.html">Home</a></li>
        <li><a href="About.html">About</a></li>
  <li><a class="noclick" href="#" >Services</a></li>
        <li><a href="ContactUs.html">Contact</a></li>
        <li><a href="Feedback.html">Feedback</a></li>
        <li><a href="Account.html">Login / Signin</a></li>
        
      </ul>
      
    </nav>
   
    
    
    
    <div class="container">
      <div class="grid-row">
       <%
		UploadControll controll = new UploadControll();
		%>
      <%
		for (UploadDto dto : controll.publish()) {
		%>
        <div class="grid-item">
        
          <span>
            <h3><%=dto.getBrand() %></h3>
            <p>Details:<%=dto.getDescription() %></p>
            <p> Price:<%=dto.getPrice() %> &nbsp; Grade:<%=dto.getGrade()%> </p>
          </span>
         
          <img src="https://www.kareseniors.com.au/wp-content/uploads/2021/08/About-Us.jpg" />
        </div>
        
       <%} %>
      </div>
    </div>
    
    <!-- main  -->


   





<!-- footer -->
<footer>
  <div id="main">
    <p>www.mobli.com   @2023  copyright</p>
  </div>
</footer>






  </body>
</html>