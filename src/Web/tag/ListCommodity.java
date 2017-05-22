package Web.tag;


import Entity.Commodity;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by cdewse on 17-5-17.
 */
public class ListCommodity extends TagSupport{

    @Override
    public int doStartTag() throws JspException {
        HttpSession session = this.pageContext.getSession();
        List<Commodity> list = (List<Commodity>) session.getAttribute("commodityList");
        JspWriter out = this.pageContext.getOut();
        try {
            out.write("<tr>" +
                    "<th>商品ID</th>" +
                    "<th>商品名称</th>" +
                    "<th>品牌</th>" +
                    "<th>进价</th>" +
                    "<th>售价</th>" +
                    "<th>质量</th>" +
                    "<th>图片</th>" +
                    "<th>类型</th>" +
                    "<th>货存</th>" +
                    "</tr>");
            for (Commodity commodity:list
                 ) {
                out.write("<tr>" +
                        "<td>" + commodity.getCid() + "</td>" +
                        "<td>" + commodity.getName() + "</td>" +
                        "<td>" + commodity.getBrand() + "</td>" +
                        "<td>" + commodity.getInputPrice() + "</td>" +
                        "<td>" + commodity.getOutputPrice() + "</td>" +
                        "<td>" + commodity.getQuality() + "</td>" +
                        "<td>" + commodity.getPicture() + "</td>" +
                        "<td>" + commodity.getType() + "</td>" +
                        "<td>" + commodity.getAmount() + "</td>" +
                        "</tr>");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
