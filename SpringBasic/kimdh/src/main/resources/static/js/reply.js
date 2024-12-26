
async function get(id) {
    const result = await axios.get(`/replies/list/${id}`)
    console.log(result)
}
// 마지막 댓글 위치로 이동하기.
async function getList({id,page,size,goLast}) {
    const result = await axios.get(`/replies/list/${id}`,
        {params: {page,size}})
    if(goLast){
        const total = result.data.total
        const lastPage = parseInt(Math.ceil(total/size))
        return getList({id:id,page:lastPage, size:size})
    }
    return result.data
}
// 댓글 등록
async function addReply(replyObj){
    const response = await axios.post(`/replies/`, replyObj)
    return response.data
}
//댓글 조회
async function getReply(rno){
    const response = await axios.get(`/replies/${rno}`)
    return response.data
}
//댓글 수정
async function updateReply(replyObj){
    const response = await axios.put(`/replies/${replyObj.rno}`,replyObj)
    return response.data
}
//댓글 삭제
async function deleteReply(rno){
    const response = await axios.delete(`/replies/${rno}`)
    return response.data
}