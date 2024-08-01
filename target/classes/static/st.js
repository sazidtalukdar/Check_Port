
const form = document.getElementById('portForm');
form.addEventListener('submit', function(check){
    check.preventDefault();

    const port= parseInt(document.getElementById('port').value);
    const host = document.getElementById('host').value;

    fetch('/check-port',{
        method :'POST',
        headers :{
            'content-type' : 'application/json',
        },
        body : JSON.stringify({host,port}),
    })

    .then(response => { 
        if(!response.ok){
        throw new Error('Not Ok');
        }
        return response.json();

    })

    .then(data =>{
        const result = document.getElementById('result');
        if(data.open){
            result.innerText=port + " Is Open";

        }else{
            result.innerText=port + " Is Closed";

        }
    })
    
    

});