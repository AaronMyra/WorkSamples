(function(){

    //create map in leaflet and tie it to the div called 'theMap'

    //3D From -- https://www.wrld3d.com/#INTRO
    var map = L.Wrld.map('theMap', '6902c01d8b986e8f0922aa3bdd4eed49', {
       center:[44.650627, -63.597140],
       zoom:14,
       environmentThemesManifest: "https://webgl-cdn1.eegeo.com/mobile-themes-new/v1141/legacy/web.manifest.bin"
    })

    var weathers = [L.Wrld.themes.weather.Clear, L.Wrld.themes.weather.Overcast, L.Wrld.themes.weather.Rainy, L.Wrld.themes.weather.Snowy];
    map.themes.setWeather(weathers[1]);

    //2D
    // var map = L.map('theMap').setView([44.650627, -63.597140], 14);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

    // Create map layer for bus icons
    var busGroup = L.layerGroup().addTo(map);

    //Bus Icon
    var busIcon = L.icon({
        iconUrl: 'bus.png',
        iconSize:     [38, 40]
    });

    retriveBusData(map, busIcon, busGroup)
})()

// Get the HRM bus api data
function retriveBusData(map, busIcon, busGroup){
    fetch('https://hrmbuses.azurewebsites.net')
    .then((response) => response.json()
    .then(function (data){

        // Requirement #1
        console.log(data);

        displayBuses(data, busIcon, map, busGroup)
    }))
}

function displayBuses(data, busIcon, map, busGroup){

    //Clears the map layer of buses
    busGroup.clearLayers();
    data.entity.forEach(bus => {
        if(bus.vehicle.trip.routeId >= 1 && bus.vehicle.trip.routeId <= 10){

            //To confirm filtering
            console.log(bus.vehicle.trip.routeId);

            //Convert the bus json to geojson
            var geojson = {
                "type": "Feature",
                "properties": {
                    "routeId": bus.vehicle.trip.routeId,
                    "longitude": bus.vehicle.position.longitude,
                    "latitude": bus.vehicle.position.latitude,
                    "bearing": bus.vehicle.position.bearing,
                    "popupContent": "Route Id: " + bus.vehicle.trip.routeId + "\n" +
                                    "Bus Id: " + bus.vehicle.vehicle.id + "\n" +
                                    "Coordinates: " + bus.vehicle.position.longitude + ", " + bus.vehicle.position.latitude
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [bus.vehicle.position.longitude, bus.vehicle.position.latitude]
                }
            };

            //Requirement #2
            console.log(geojson);

            //Requirement #3
            // Add the bus geojson to map layer
            L.geoJSON(geojson, {
                pointToLayer: function (feature, latlng) {
                    return L.marker(latlng, {
                        icon: busIcon,
                        rotationAngle: bus.vehicle.position.bearing
                    });
                }
            }).bindPopup(function (layer) {
                 return "<b>Route Id: </b>" + geojson.properties.routeId + "<br>" + 
                        "<b>Bearing: </b>" + geojson.properties.bearing + "<br>" + 
                        "<b>Longitude: </b>" + geojson.properties.longitude + "<br>" + 
                        "<b>Latitude: </b>" + geojson.properties.latitude;
            }).addTo(busGroup);
        }
    });

    //Requirement #4
    //Set function recursive
    setTimeout(() => {
        retriveBusData(map, busIcon, busGroup);
    }, 5000);
}