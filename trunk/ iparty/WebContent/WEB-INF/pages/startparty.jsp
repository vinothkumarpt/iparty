<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/global.css">
<title>Begin party </title>
</head>
<body>
<div class="center_page" ng-app="mainApp" ng-controller="mainController">
	<div id='header'>
		<div id="header_left">
			<span id="header_left_text_1">
				I Party
			</span>
			<span id="header_left_text_2">
				Come, Organize and Celebrate 
			</span>
		</div>
		
		<div id="header_right">
			<div id="login_input">
				<label id="username_label" for="username" class="login_input">username</label>
				<input id="username" type="text" class="login_input"></input>
				<label id="password_label" for="password" class="login_input">password</label>
				<input id="password" type="text" class="login_input"></input>
			</div>
		</div>
		
	</div>
	<div id='main_content'>
	<div style="width:100%;padding-top:50px;">
		<span style="padding-left:30px;">
			First time User? Let us begin a Party
		</span>
	</div>
	<div style="width:100%;">
		<span  style="padding-left:30px;">
			Add members
		</span>
	</div>
	<div style="width:100%;height:300px;">
		<div id="membersArea">
			<textarea  style="width:300px;height: 100px;">
			</textarea>
		</div>
		<div id='emailIdContainer'>
				<span style="padding-left: 60px;">Name (optional)</span>
				<table>
					<tr ng-repeat="emailObj in emailIds">
						<td>
							{{'invite'+($index+1)}}
						</td>
						<td>
							<input type="text" ng-model="emailObj.userName"></input>
						</td>
						<td>
							<input type="text" ng-model="emailObj.userEmail" ></input>
						</td>
						<td>
							<div class="add" ng-click="handleAdd()"></div>
						</td>
						<td>
							<div class="remove" ng-click="handleRmv($index)"></div>
						</td>
					</tr>
				</table>
			</div>
	</div>
	<div  id="actionButtonSec" style="width:100%;">
		
		<div id="nextBtn" class="next"  ng-click="handleEmailSave()">
			
		</div>
	</div>
		
	</div>
	
	<div id='footer'>
		<span style="display: block;text-align: center;"> To do footer section </span>
	</div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script>
var mainApp = angular.module("mainApp", []);

mainApp.controller('mainController', function($scope,$http) {
   $scope.loginUser = {
      userName: "",
      passWord: ""
     
   };
   $scope.emailIds = [
                      {userName:'',userEmail:''},
                      {userName:'',userEmail:''},
                      {userName:'',userEmail:''},
                      {userName:'',userEmail:''}
                      ];
   $scope.handleAdd = function(){
	   
	   $scope.emailIds.push( {name:'',emailId:''});
   }
   $scope.handleRmv = function(index){
	   
	   $scope.emailIds.splice(index,1);
   }
   $scope.handleEmailSave = function(){
	   $http.post('http://localhost:8081/iparty/rest/service/userRegist',$scope.emailIds).
	   success(function(){
		    alert("successfully saved");
	   }).error(function(){
		   alert("failure ");
	   });
	   
   }
});
</script>
</body>
</html>