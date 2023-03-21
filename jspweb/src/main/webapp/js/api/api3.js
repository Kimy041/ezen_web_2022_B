/*------------------------ 지도 옵션 및 생성 ------------------------------------*/
var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(37.3218778,126.8308848),
	level: 5
};
var map = new kakao.maps.Map(container, options);

/*------------------------------- 주소 좌표 ----------------------------------*/
/*// 공공데이터
let positions = [];

$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=uqDeckQgXrBxTbpjWQQipiqeaa6Hjua%2F2z%2FenRkuNzABtujDNvyP1NkVpBZ2mifI%2BuEUiw0nW64TrfPcJn%2BCXg%3D%3D" ,
	method : "get" ,
	async : 'false' ,
	success : (r)=>{
		console.log(r.data); 
		for( let i = 0 ; i< r.data.length ; i++ ){
			let info ={
				title : r.data[i].약국명 ,
				address : r.data[i].주소
			}
			positions.push( info )
		}
		console.log( positions )
		/*------------------------------------------------------*/
		// 주소-좌표 변환 객체를 생성합니다
/*		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		for(let i = 0 ; i < positions.length ; i++ ){
			
			geocoder.addressSearch(positions[i].address, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords ,
			            image : markerImage // 마커 이미지 
			        });
			
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: `<div style="width:150px;text-align:center;padding:6px 0;">${ positions[i].title }</div>`
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});
		}
	}
})*/
/*------------------------ 마커 클러스터[ 마커들을 관리 ] ------------------------------------*/
// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 6 // 클러스터 할 최소 지도 레벨 
});


coord();
function coord(){
	$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=uqDeckQgXrBxTbpjWQQipiqeaa6Hjua%2F2z%2FenRkuNzABtujDNvyP1NkVpBZ2mifI%2BuEUiw0nW64TrfPcJn%2BCXg%3D%3D" ,
	method : "get" ,
	async : 'false' ,
	success : (r)=>{
		
		/*------------------------------------------------------*/
		// 주소-좌표 변환 객체를 생성합니다
		let geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		for(let i = 0 ; i < r.data.length ; i++ ){
			
			geocoder.addressSearch(r.data[i].주소, function(result, status) {
			
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
					
					   
			 	        let marker = new kakao.maps.Marker({
				            position :new kakao.maps.LatLng(result[0].y, result[0].x) ,
				            image : markerImage // 마커 이미지 
				        });
										 	
				 		
					 	
					 	clusterer.addMarker(marker); // 클러스터러에 마커들/배열을 추가합니다
					 	
					 	// 위에서 생성된 마커객체의 클릭 이벤트 추가 하기
					kakao.maps.event.addListener(marker, 'click', function() {
						 
						 // 모달 정보 담기
						 document.querySelector('.modal_title').innerHTML = r.data[i].약국명;
						 document.querySelector('.modal_title').style.fontSize = '15px'
						 // 모달 띄우기
						 onpenModal();
						});
			    	} 
				});
			}
		}
	})
}



/*------------------------ 마커 이미지 변경 ------------------------------------*/
var imageSrc = '/jspweb/img/mortar.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(30, 30), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
  
 /*----------------------- 지도 클릭 이벤트 --------------------------------*/
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});
