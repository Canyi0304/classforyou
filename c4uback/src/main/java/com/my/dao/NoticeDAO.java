package com.my.dao;

import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.Notice;

public interface NoticeDAO {
	
	/**사용자, 관리자 모두 사용
	 * 공지사항 전체 목록을 페이지에 별로 조회
	 * @param currentPage 공지사항의 현재 페이지
	 * @param cnt_per_page 한 페이지 당 존재하는 게시물 수
	 * @return List<Notice> 공지사항 리스트
	 * @throws FindException 공지사항이 없으면, 예외가 발생한다. 
	 */
	List<Notice> selectPerPage(int currentPage,  int cnt_per_page) throws FindException;
	
	/** 사용자, 관리자 모두 사용
	 * 공지사항 게시판 페이징 처리를 위하여, 게시글 전체 조회
	 * @return int DB에 저장된 공지사항 게시글 개수 
	 * @throws FindException 공지사항 게시글이 없으면, 예외가 발생한다.
	 */
	int selectCnt() throws FindException;
	
	/** 사용자, 관리자 모두 사용
	 * 공지사항 게시판 중 검색 단어가 있는 글 조회
	 * @param notice_title 검색어
	 * @param currentPage 현재 페이지
	 * @param cnt_per_page 한 페이지당 게시 글 수
	 * @return List<Notice> 검색된 공지사항 목록
	 * @throws FindException 검색어와 일치하는 공지사항이 없을 경우, 예외가 발생한다.
	 */
	List<Notice> selectByTitlePerPage(String notice_title, int currentPage, int cnt_per_page) throws FindException;
	
	/**사용자, 관리자 모두 사용
	 **공지사항 상세 조회
	 * 공지사항 상세 조회
	 * @param  notice_id 공지글번호
	 * @return Notice 공지사항객체
	 * @throws FindException 공지글번호에 해당하는 공지사항 게시글이 없으면, 예외가 발생한다
	 */
	Notice selectById(int notice_id)  throws FindException;
	
	/** 관리자 사용
	 * 공지사항 1개 수정
	 * @param notice 수정된 내용이 담긴 공지사항 객체
	 * @return Notice 수정된 공지사항 객체
	 * @throws ModifyException 수정할 공지사항 객체가 없을 경우, 예외가 발생한다.
	 */
	Notice update(Notice notice) throws ModifyException;
	
	/** 관리자 사용
	 * 공지사항 1개 삭제
	 * @param notice_id 삭제하고자 하는 공지사항 notice_id
	 * @return int 삭제한 공지사항 번호
	 * @throws RemoveException 삭제할 공지사항 객체가 없을 경우, 예외가 발생한다.
	 */
	int delete(int notice_id) throws RemoveException;
	
	/** 관리자 사용
	 * 공지사항 1개 추가
	 * @param notice 작성한 공지사항 객체
	 * @throws AddException 작성한 공지사항 객체가 없을 경우, 예외가 발생한다. 
	 */
	void insert(Notice notice) throws AddException;
}