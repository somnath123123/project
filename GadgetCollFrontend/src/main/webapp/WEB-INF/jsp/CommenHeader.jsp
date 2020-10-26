<%@ page language="java" contentType="text/html"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
 <html>
<head>
     <title>Website</title>
     <script style="text/javascipt">
     $(function(){
    	    $('.button-checkbox').each(function(){
    			var $widget = $(this),
    				$button = $widget.find('button'),
    				$checkbox = $widget.find('input:checkbox'),
    				color = $button.data('color'),
    				settings = {
    						on: {
    							icon: 'glyphicon glyphicon-check'
    						},
    						off: {
    							icon: 'glyphicon glyphicon-unchecked'
    						}
    				};

    			$button.on('click', function () {
    				$checkbox.prop('checked', !$checkbox.is(':checked'));
    				$checkbox.triggerHandler('change');
    				updateDisplay();
    			});

    			$checkbox.on('change', function () {
    				updateDisplay();
    			});

    			function updateDisplay() {
    				var isChecked = $checkbox.is(':checked');
    				// Set the button's state
    				$button.data('state', (isChecked) ? "on" : "off");

    				// Set the button's icon
    				$button.find('.state-icon')
    					.removeClass()
    					.addClass('state-icon ' + settings[$button.data('state')].icon);

    				// Update the button's color
    				if (isChecked) {
    					$button
    						.removeClass('btn-default')
    						.addClass('btn-' + color + ' active');
    				}
    				else
    				{
    					$button
    						.removeClass('btn-' + color + ' active')
    						.addClass('btn-default');
    				}
    			}
    			function init() {
    				updateDisplay();
    				// Inject the icon if applicable
    				if ($button.find('.state-icon').length == 0) {
    					$button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
    				}
    			}
    			init();
    		});
    	});
     </script>
    <style type="text/css">
    .colorgraph {
    	  height: 5px;
    	  border-top: 0;
    	  background: #c4e17f;
    	  border-radius: 5px;
    	  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
    	  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
    	  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
    	  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
    	}
    </style>
</head>
<body>
<c:set var="flag" value="0"/>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
      <a class="navbar-brand" href="#">Om-Mobile shop</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index">Home</a></li>
        <c:if test="${flag==0}">
       
        <li><a href="SignIn">Login</a></li>
        <li><a href="SignUp">Register</a></li>
        <li><a href="AboutUs">About Us</a></li>
        <li><a href="ContactUs">Contact Us</a></li>
        </c:if>
          <c:if test="${flag==1}">
        <li><a href="showCategory">Manage Category</a></li>
        <li><a href="showSupplier">Manage Supplier</a></li>
        <li><a href="showProduct">Manage Product</a></li>
        <li><a href="showCustomer">Manage Customer</a></li>
      
       </c:if>
      </ul>
       
      <ul class="nav navbar-nav navbar-right">
        <li><a href="SignUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="SignIn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>