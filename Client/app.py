"""
@auother: Nuyun-Kalamullage
@package: CurencyConvertorClient
@date: 22.12.2022
"""
from flask import Flask
from views import views

app = Flask(__name__)
app.register_blueprint(views,url_prefix="/")

if __name__ == '__main__':
    app.run(debug=True,port = 8000)