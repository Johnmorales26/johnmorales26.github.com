document.getElementById('string_inner_container').innerHTML = create_random_string(10)

    function create_random_string(string_length){
        var random_string = '';
        var characters = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789abcdefghijklmnñopqrstuvwxyz'
        for(var i, i = 0; i < string_length; i++){
            random_string += characters.charAt(Math.floor(Math.random() * characters.length))
        }
        return random_string
    }
