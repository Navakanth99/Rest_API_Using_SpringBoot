<% @page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
</head>
<body>
  <header>
    <h1>HTML5 Example Page</h1>  
	
	<table border="2"> 
		<tr>
		   <th>Team Name</th>	
		   <th>Team Captain</th>	
		   <th>Team Owner</th>	
		   <th>Trophies</th>	
		</tr>
		
		 
		<% 
		List<IPLTeams> ipl = (List<IPLTeams>) request.getAttribute("iplteams");
			
			for(IPLTeams iplteam : ipl){
				
			}
			 %>
	</table>
  </header>
</body>
</html>
	