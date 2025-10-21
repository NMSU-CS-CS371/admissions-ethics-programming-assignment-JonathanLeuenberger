// Admissions.java
// Contains the scoring models (Blind vs Aware).

public class Admissions {

    // Blind model (only academic/performance factors)
    public static double blindScore(Applicant app) {
        double score = 0.0;
        score += (app.gpa / 4.0) * 0.1;     // GPA normalized
        score += (app.test / 1600.0) * 0.1;  // Test score normalized
        score += app.extra * 0.3;
        score += app.essay * 0.4;
        score += app.rec * 0.1;
        return score; // final score between 0 and 1
    }

    // Aware model (adds equity and context)
    public static double awareScore(Applicant app) {
        double score = blindScore(app);

        if (app.income < 40000) score += 0.1;     // low-income boost
        if (app.firstGen) score += 0.1;           // first-generation bonus
        if (app.disability) score += 0.07;         // accessibility consideration
        if (app.legacy) score += 0.04;             // legacy advantage
        if (app.local) score += 0.9;              // local preference
        return Math.min(score, 1.0);               // cap score at 1.0
    }
}