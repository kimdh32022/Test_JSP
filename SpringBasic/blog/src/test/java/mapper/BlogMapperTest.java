package mapper;

import com.busanit501.blog.domain.BlogVO;
import com.busanit501.blog.dto.PageRequestDTO;
import com.busanit501.blog.mapper.BlogMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class) //JUnit5 테스트 설정.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BlogMapperTest {

    @Autowired(required = false)
    private BlogMapper blogMapper;

    @Test
    public void testGetTime() {
        log.info("getTime : " + blogMapper.getTime());
    }

    @Test
    public void testInsert() {
        BlogVO blogVO = BlogVO.builder()
                .title("샘플 테스트")
                .content("내용")
                .date(LocalDate.now())
                .writer("김도현")
                .build();
        blogMapper.insert(blogVO);
    }

    @Test
    public void testSelectAll() {
        List<BlogVO> lists = blogMapper.selectAll();
        for (BlogVO blogVo:lists) {
            log.info("blogVo : " + blogVo);
        }
    }

    @Test
    public void testSelectOne() {
        BlogVO  blogVo = blogMapper.selectOne(9L);
            log.info("blogVo : " + blogVo);
    }

    @Test
    public void testDelete() {
        blogMapper.delete(9L);
    }

    @Test
    public void testUpdate() {
        // 업데이트 할 더미 데이터 필요, BlogVO
        BlogVO blogVO = BlogVO.builder()
                .bno(6L)
                .title("수정 제목")
                .date(LocalDate.now())
                .build();

        blogMapper.update(blogVO);
    }

    // 페이징 처리해서 전체 조회
    @Test
    public void testSelectAllWithPage() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .keyword("수정")
                .types(new String[]{"t","w"})
                .from(LocalDate.of(2024,12,05))
                .to(LocalDate.of(2024,12,06))
                .build();

        List<BlogVO> list = blogMapper.selectList(pageRequestDTO);
        list.forEach(vo -> log.info("vo : " + vo));
    }
    @Test
    public void testGetCount() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .keyword("수정")
                .types(new String[]{"t","w"})
                .from(LocalDate.of(2024,12,05))
                .to(LocalDate.of(2024,12,06))

                .build();
        int total = blogMapper.getCount(pageRequestDTO);
        log.info("total : " + total);
    }

}
