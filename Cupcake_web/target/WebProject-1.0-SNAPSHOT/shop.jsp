<%@include file="includes/header.jsp" %>
<h1>CupCake Shop</h1>
<div id="shopbox">
            <div id="left-box">
            <p>Topping</p> <select id="topSel" name="top">
                <option value="null">-//-</option>
                <option value="choco">Chocolate</option>
                <option value="blue">Blueberry</option>
                <option value="ras">Rasberry</option>
                <option value="cri">Crispy</option>
                <option value="straw">Strawberry</option>
                <option value="rum">Rum/Raisin</option>
                <option value="or">Orange</option>
                <option value="le">Lemon</option>
                <option value="bluec">Blue Chesse</option>
                
            </select>
            <p>Bottom</p> <select id="botsel" name="bot">
                <option value="null">-//-</option>
                <option value="choco">Chocolate</option>
                <option value="van">Vanilla</option>
                <option value="nut">Nutmeg</option>
                <option value="pis">Pistachio</option>
                <option value="al">Almond</option>
                
            </select>
            <form action="shop.jsp" method="post">
                <p>Quantity:</p> <input type="number" name="quantity" min="1" max="10">
                <input type="submit" value="Check Out">
            </form>
            </div>
            <div id="right-box">
                <div class="shopimg">
                    <img src="includes/billeder/10550968_10152867614835101_4636379771796450625_n.jpg" alt="Mads">
                </div>
                <div class="shopimg">
                    <img src="includes/billeder/moist-chocolate-cupcakes-5.jpg" alt="Cupcake">
                </div>
            </div>
        </div>
<%@include file="includes/footer.jsp" %>
