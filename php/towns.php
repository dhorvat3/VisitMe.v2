<?php
 
$response = array();
 
require_once __DIR__ . '/db_connect.php';
 
$db = new DB_CONNECT();
 
$results = array();
$results = mysql_query("SELECT * FROM  `town` ");
 
      
$apartment = array();
        
        
$response["towns"] = array();
           
while ($result = mysql_fetch_assoc($results)){
 
	 $town["town_name"] = $result["t_name"];
	 array_push($response["towns"], $town);
	 
 	}
          
echo json_encode($response);
            
            
?>
