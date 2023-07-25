$(document).ready(function() {
                console.log('page load OK')
                const pscToken = getJeton();
                console.log('jeton: ' + pscToken);
                const splited=pscToken.split('.');
                const header=atob(splited[0]);
                console.log('header: ' + header);
                const body=atob(splited[1]);
                console.log('body: ' + body);

                //https://www.cssscript.com/minimal-json-data-formatter-jsonviewer/#google_vignette
                let jsonViewerHeader = new JSONViewer();
                document.querySelector("#json-header").appendChild(jsonViewerHeader.getContainer());               
                jsonViewerHeader.showJSON(header, -1, -1);
                
                let jsonViewerBody = new JSONViewer();
                   document.querySelector("#json-body").appendChild(jsonViewerBody.getContainer());               
                jsonViewerBody.showJSON(body, -1, -1);
                
        });                
function getJeton(){
 return $("#token").val();
}

