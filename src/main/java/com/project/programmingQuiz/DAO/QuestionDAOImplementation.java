package com.project.programmingQuiz.DAO;

import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Service.QuestionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImplementation implements QuestionDAO{

    private EntityManager entityManager;

    @Autowired
    public QuestionDAOImplementation(EntityManager newEntityManager){
        entityManager = newEntityManager;
    }

    @Override
    public List<Question> findAll() {
        TypedQuery<Question> findAllQuery = entityManager.createQuery("from Question", Question.class);
        List<Question> allQuestions = findAllQuery.getResultList();

        return allQuestions;
    }

    @Override
    public List<Question> findByCategory(String selectedCategory) {
        TypedQuery<Question> findByCategory = entityManager.createQuery("FROM Question WHERE category=:theCategory", Question.class);
        findByCategory.setParameter("theCategory", selectedCategory);

        List<Question> selectedQuestions = findByCategory.getResultList();

        return selectedQuestions;
    }

    @Override
    public Question findById(int questionId) {
        return entityManager.find(Question.class, questionId);
    }

    @Override
    public void deleteByQuestion(Question questionObject) {
        entityManager.remove(questionObject);
    }

    @Override
    public Question updateByQuestion(Question requestedQuestion) {
        return entityManager.merge(requestedQuestion);
    }

    @Override
    public List<Question> findRandomQuestionsByCategory(String category, int noOfQuestions) {
        TypedQuery<Question> randomQuestionsQuery = entityManager.createQuery("FROM Question WHERE category=:theCategory ORDER BY rand()", Question.class);

        randomQuestionsQuery.setMaxResults(noOfQuestions);
        randomQuestionsQuery.setParameter("theCategory", category);

        List<Question> questions = randomQuestionsQuery.getResultList();
        return questions;
    }

    @Override
    public Question save(Question requestedQuestion) {
        return entityManager.merge(requestedQuestion);
    }

}
