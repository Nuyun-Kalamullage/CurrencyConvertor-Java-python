"""
@auother: Nuyun-Kalamullage
@package: CurencyConvertorClient
@date: 22.12.2022
"""
import json
import os
import zeep

from flask import Blueprint, render_template, request

views = Blueprint(__name__, "view")
client = zeep.Client('http://localhost:8888/SoapWebService?wsdl') # set your wsdl url here.

@views.route("/", methods=['GET', 'POST'])
def home():
    currency = currency_data()
    currency = {value: key for key, value in currency.items()}
    lables = list(currency.keys())
    firstCurr = lables[85]
    secondCurr = lables[149]
    firstAmount = None
    secondAmount = 0.00
    if request.method == 'POST':
        firstAmount = request.form['first_amount']
        firstCurr = request.form['selectedFirstCurrency']
        secondCurr = request.form['selectedSecondCurrency']
        print(currency.get(firstCurr), firstAmount, secondCurr)
        secondAmount = client.service.convert(currency.get(firstCurr),currency.get(secondCurr),firstAmount)
    return render_template("index.html", firstAmount=firstAmount, secondAmount=secondAmount, currencyList=lables, firstCurrency=firstCurr, secondCurrency=secondCurr)


def currency_data():
    """ All countries' currency data """
    module_dir = os.path.dirname(__file__)  # get current directory
    file_path = os.path.join(module_dir, 'res', 'currencies.json')
    with open(file_path, "r") as f:
        currency_data_dict = json.loads(f.read())
    return currency_data_dict




