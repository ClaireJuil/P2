$(document).ready(function() {
                console.log('page load OK')
                let pscToken = getJeton();
                console.log('jeton' + pscToken);
        });
function getJeton(){
 return $("#token").val();
 
}

