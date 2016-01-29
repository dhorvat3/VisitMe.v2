<?php
 
$response = array();
 
require_once __DIR__ . '/db_connect.php';
 
$db = new DB_CONNECT();
 
if (isset($_GET["id_town"])) {
    $id_town = $_GET['id_town'];
 
    $results = array();
    $results = mysql_query("SELECT ap.ap_name, t.t_name, ap.price, a.address, ap.free, a.lat, a.lng
							FROM apartment ap 
							LEFT JOIN address a on a.id_address = ap.id_address
							LEFT JOIN town t on t.id_town = ap.id_town
							WHERE t.id_town = $id_town
							GROUP BY ap.ap_name;");
 
    if (!empty($results)) {
       
        if (mysql_num_rows($results) > 0) {
        
           $apartment = array();
        
  	   $response["success"] = 1;
 
          
           $response["apartment"] = array();
           
           while ($result = mysql_fetch_assoc($results)){
 
            
            $apartment["apartment_name"] = $result["ap_name"];
            $apartment["town_name"] = $result["t_name"];
            $apartment["price"] = $result["price"];
            $apartment["address"] = $result["address"];
            $apartment["free"] = $result["free"];
            $apartment["lat"] = $result["lat"];
			$apartment["long"] = $result["lng"];
          
           
 
            array_push($response["apartment"], $apartment);
 }
          
            echo json_encode($response);
            
            
        } else {
           
            $response["success"] = 0;
            $response["message"] = "No apartment found";
 
            
            echo json_encode($response);
        }
    } else {
       
        $response["success"] = 0;
        $response["message"] = "No apartment found";
 
        
        echo json_encode($response);
    }
} else {
   
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
  
    echo json_encode($response);
}
?>
