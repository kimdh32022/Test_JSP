package com.busanit501.kimdh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String keyword;
    private String page;
    private String type;

    private String link2;

    public String getLink() {
        if (link2 == null || link2.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);

            if (type != null && type.length() > 0) {
                builder.append("&type="+ type);
            }

            if(keyword != null) {
                try {
                    builder.append("&keyword="+ URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                link2 = builder.toString();
            } //if

        } //if
        return link2;
    }
}
