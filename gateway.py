@app.route("/test-car-model", methods=['POST'])
def uploadImage():
    if request.method == 'POST':
        print("dsanodsao")
        if 'file' not in request.files:
            flash('No file part')
            return redirect(request.url)
        file = request.files['file']
        if file.filename == '':
            flash('No selected file')
            return redirect(request.url)
        img = Image.open(file)
        img = img.convert('L')
        img.save('./data/test/test.jpg')
        print(type(util.IP))
        url = "http://"+util.IP+":"+str(util.CAR_DETECTION_SERVICE_PORT)+"/test-model"
        params = {'image_url': './data/test/test.jpg'}
        response = requests.get(url = url, params = params)
        print(response.json())
        predictions = requests.get(url)
        response = {
            'predictions': predictions
        }
        return jsonify(response)
    response = {
        'message': "Something went wrong!",
        'code': 500
    }
    return jsonify(response)
