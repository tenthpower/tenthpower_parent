package com.tenthpower.service;

import com.tenthpower.dao.ColumnDao;
import com.tenthpower.dao.CommentDao;
import com.tenthpower.dto.article.ColumnVo;
import com.tenthpower.dto.article.CommentVo;
import com.tenthpower.pojo.Column;
import com.tenthpower.pojo.Comment;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final Logger log = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;


    public void add(CommentVo commentVo){
        Comment comment = new Comment();
        BeanCopierEx.copy(commentVo, comment);
        comment.set_id(idWorker.nextId());//设置ID
        commentDao.save(comment);
    }

    /**
     * 获取文章评论
     * @param articleId
     * @return
     * @throws Exception
     */
    public List<CommentVo> findByArticleid(String articleId) throws Exception {
        List<Comment> sqlList = commentDao.findByArticleId(articleId);
        List<CommentVo> result = new ArrayList<>();
        if (null != sqlList && sqlList.size() > 0) {
            result = BeanCopierEx.copy(sqlList, CommentVo.class);
        }
        return result;
    }

    /**
     * 删除评论
     */
    public void deleteComment(String commentId){
        commentDao.deleteById(commentId);
    }

}
